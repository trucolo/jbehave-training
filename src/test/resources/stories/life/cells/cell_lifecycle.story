Meta:

Narrative:
As a Conway's Game of Life universe
I want to make cells evolve
So that we can see some beautiful patterns

Scenario: Cell reproduction
Given a dead cell
And the cell has 3 live neighbours
When the cell evolves to the next generation
Then the cell is now alive

Scenario: Cell death by over population
Given a live cell
And the cell has 4 live neighbours
When the cell evolves to the next generation
Then the cell is now dead