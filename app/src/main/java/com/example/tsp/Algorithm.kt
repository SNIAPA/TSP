package com.example.tsp

import android.util.Log
import kotlinx.coroutines.selects.whileSelect

fun <T> allPermutations(set: Set<T>): Sequence<List<T>> = sequence {
    if (set.isEmpty()) yield(listOf())

    fun <T> _allPermutations(list: List<T>): List<List<T>> {
        if (list.isEmpty()) return listOf(emptyList())

        val result: MutableList<List<T>> = mutableListOf()
        for (i in list.indices) {
            _allPermutations(list - list[i]).forEach{
                    item -> result.add(item + list[i])
            }
        }
        return result
    }

    return@sequence yieldAll(_allPermutations(set.toList()))
}


class Algorithm {

    var graph:Graph;

    constructor(graph: Graph){
        this.graph = graph
    }

    fun solve(){
        val permutationSeauence = allPermutations((0 .. graph.nodeCount).toSet())


        for (permutation in permutationSeauence){
            Log.d("Balls",permutation.toString())






        }


    }


}