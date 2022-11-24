package com.example.tsp

import kotlin.random.Random

data class Edge(val n1:Int,val n2: Int, val c:Int)
data class Vertex(val n: Int, val c:Int)

class Graph(val nodeCount: Int,val edgeCount: Int) {
    lateinit var adjacencyList: List<List<Vertex>>
    lateinit var edges: List<Edge>

    constructor(nodeCount: Int = 16, edgeCount: Int = 10, maxEdgeCost: Int = 10) : this(nodeCount,edgeCount) {

        val mutableAL : List<MutableList<Vertex>> = List(nodeCount) { mutableListOf() }
        val mutableEdges = MutableList(edgeCount) { Edge(0, 0, 0) }

        for(i in 0 until edgeCount){

            val n1 = Random.nextInt(nodeCount)
            val r = Random.nextInt(nodeCount - 1)

            // assure that the 2 random numbers are not the same
            val n2 = if (n1 >= r) r else (r + 1)

            val c = Random.nextInt(1,maxEdgeCost)

            mutableAL[n1].add(Vertex(n2,c))
            mutableAL[n2].add(Vertex(n1,c))

            mutableEdges.add(Edge(n1,n2,c))

        }

        adjacencyList = mutableAL
        edges = mutableEdges
    }


}