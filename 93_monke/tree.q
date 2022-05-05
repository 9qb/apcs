(P)BNJ :: Brian Li, Nakib Abedin, Jefford Shau
APCS pd7
HW93 -- exploring tree properties, extracting actionable intel from traversals
2022-05-05r
time spent: 0.8 hrs


DISCO
------------------------------------------------
* Through the last few questions, we analyzed the relationship between balanced, complete, and perfect trees.
================================================


QCC
------------------------------------------------
* Some of these questions were hard to understand and reason through.
================================================


SELF-ASSESSMENT PROMPTS
------------------------------------------------
-- In which direction does a tree grow?
A tree always grows downwards.

-- Provide as many alternate definitions as you can for "tree," using graph terminology ("closed/open tours", "paths", "cycles", etc). Maximize clarity, succinctness.
A tree is a path whose nodes are connected via an open tour, where each node is traveled to once and only once.

-- Why is a balanced tree allowed a difference of 1 in height between right and left subtrees?
In the case of a depth-first processing of the tree, a tree with a minimal difference between subtrees allows for maximum efficiency. We can travel to any node much faster if the tree is balanced. It is unlikely that a tree's subtrees are equal in height, so a difference of 1 is optimal.

-- Alternate (equivalent, but more succinct?) definitions of "balanced" tree?
A tree whose subtree heights are within one level of each other.

-- Is a perfect tree complete?
A perfect tree is complete. Every level of a perfect tree is filled, including the lowest level, which makes it complete.

-- Is a complete tree balanced?
A complete tree is not always balanced. In a complete tree, the second to lowest level may have multiple nodes that are missing leaves since a tree can be complete as long as the lowest level is left justified.

-- Is the Man Who Is Tall Happy?
The Man Who is Tall (root node) is happy because he has a big extended family (children nodes on multiple levels).

-- What must be true of perfect trees but not others?
Perfect trees must have every level filled, meaning that all nodes are parents with 2 child nodes except for the lowest level. The lowest level nodes are all leaves.
================================================


C'EST POSSIBLE?
------------------------------------------------
It is possible to reconstruct a possible tree, but since multiple variations of trees are possible, it is impossible to determine if the tree we reconstructed is the same as the original. There must be other requirements (e.g., balanced, complete, and perfect) to reconstruct a specific tree.
================================================
