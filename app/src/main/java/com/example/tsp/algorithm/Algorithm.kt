package com.example.tsp.algorithm


class Algorithm {


    private fun <T>permutations(list: List<T>)  = sequence<List<T>> {
        val factorials = IntArray(list.size + 1)
        factorials[0] = 1
        for (i in 1..list.size) {
            factorials[i] = factorials[i - 1] * i
        }
        for (i in 0 until factorials[list.size]) {
            var onePermutation = mutableListOf<T>()
            var temp = list
            var positionCode = i
            for (position in list.size downTo 1) {
                val selected = positionCode / factorials[position - 1]
                onePermutation += temp[selected]
                positionCode %= factorials[position - 1]
                temp = list.subList(0, selected) + temp.subList(selected + 1,temp.size);
            }
            yield(onePermutation)
        }
    }

    var graph: Graph;

    constructor(graph: Graph){
        this.graph = graph
    }

    private fun calculatePath(permutation: List<Int>): Double? {

        var currentPath = 0.toDouble()
        for (i in 1 until permutation.size){

            val n1 = permutation[i-1]
            val n2 = permutation[i]

            val edge = graph.getEdge(n1,n2)

            currentPath +=  edge

        }
        return currentPath
    }

    fun solve(): Pair<List<Int>, Double>? {
        val permutations = permutations((0 until graph.vertices.size).toList() )

        var ans = Pair(listOf<Int>(),Double.MAX_VALUE.toDouble())

        for (permutation in permutations){

            var currentPath = calculatePath(permutation) ?: continue

            if (currentPath <  ans.second) {
                ans = Pair(permutation,currentPath)

            }
        }

        if (ans.second == Double.MAX_VALUE){

            return null
        }
        return ans


    }


}