# TSP - the app
## Description

This is an application to find a shortest possible path for visiting all cities in a list; its also called the traveling salesman problem(TSP).
The maximum number of cities will be limited to 16 by default for time complexity reasons.
  
## User Interface

- graph creation
  1. adding cities
  2. addng conections
  3. confirm
  4. ? preview of the graph
  5. generate random graph button
  6. ? checkmark to allow more than 16 cities with a warning that it will take a long time 
- ? path calculation
  1. nodes visited
  2. current node
  3. current path
  4. approximated % done
- result
  1. path
  2. cost
  3. save screenshot
  
## Algorithm

This algorith uses the brute force approach. It generates all possible paths and remembers the shortest one it saw.

## Goals
- [x] graph structure
- [x] random graph generation
- [x] algorithm itself 
- [x] graph creation view
- [x] result view
- [x] result saving
