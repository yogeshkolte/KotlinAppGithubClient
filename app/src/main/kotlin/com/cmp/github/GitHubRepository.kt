package com.cmp.github

import com.cmp.github.model.*
import com.cmp.github.network.GitHubApi
import com.google.common.collect.MinMaxPriorityQueue
import kotlinx.datetime.Instant
import java.time.Duration
import java.time.temporal.ChronoUnit
import java.util.*

class GitHubRepository {
    suspend fun getRepos(userName: String?, token: String?): DisplayResult {
        val accessToken = "Bearer ${token}"
        val displayString: StringBuilder = java.lang.StringBuilder()
        try {
            var commitsForUser = mutableListOf<List<CommitInfo>>()
            val response = GitHubApi.gitHubService.getRepos(accessToken)
            response?.sortedByDescending {
                Instant.parse(it.updated_at).epochSeconds
            }.forEach {
                val repoName = it.name
                try {
                    val commits = GitHubApi.gitHubService.getCommits(
                            accessToken,
                            userName ?: "",
                            repoName
                    )
                    commitsForUser.add(commits)
                } catch (e: Exception) {
                    println(e.message)
                }
            }
            var cnt = 60;
            val queueSize = 60
            val sixtyCommits = MinMaxPriorityQueue.maximumSize(queueSize).create<CommitInfo>()

            for (lstCommitInfo in commitsForUser) {
                if (sixtyCommits.size < queueSize) {
                    sixtyCommits.addAll(lstCommitInfo)
                }
                else{
                    for(commitInfo in lstCommitInfo){
                        val lastCommitInfo = sixtyCommits.peekLast()
                        if(commitInfo?.commit?.committer?.date < lastCommitInfo?.commit?.committer?.date){
                            println()
                            break;
                        }
                        cnt++
                        sixtyCommits.add(commitInfo)
                    }
                }
            }
            println("Total commits processed ${cnt}")
            var timeIntervale = mutableListOf<Long>()
            var lastDate: Date? = null

            var commitInfo = sixtyCommits.poll()
            while (commitInfo != null) {
                if (lastDate != null) {
                    timeIntervale.add(ChronoUnit.MILLIS.between(commitInfo?.commit?.committer?.date?.toInstant(), lastDate.toInstant()))
                }
                lastDate = commitInfo?.commit?.committer?.date

                displayString.append("${commitInfo?.commit?.committer?.date} - ${commitInfo?.commit?.message} ")
                displayString.append("\n")

                commitInfo = sixtyCommits.poll()
            }
            val avg = timeIntervale.average()
            displayString.insert(0, "Mean Time milliseconds ${avg} \n \n")
        } catch (e: Exception) {
            println(e.message)
        }
        return DisplayResult(displayString.toString(), 0)
    }
}