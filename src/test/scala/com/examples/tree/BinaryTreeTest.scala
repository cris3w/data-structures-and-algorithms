package com.examples.tree

import org.scalatest.{FunSpec, Matchers}

class BinaryTreeTest extends FunSpec with Matchers {

  private val tree = Node("F", Node("B", Leaf("A"), Node("D", Leaf("C"), Leaf("E"))), Node("G", Empty, Node("I", Leaf("H"), Empty)))

  describe("BinaryTree") {

    it("height of the longest branch") {
      tree.height shouldBe 4
    }

    it("number of nodes") {
      tree.nodes shouldBe 9
    }

    it("number of nodes that are leaves") {
      tree.leaves shouldBe 4
    }

    it("mirror image") {
      tree.mirror shouldBe Node("F", Node("G", Node("I", Empty, Leaf("H")), Empty), Node("B", Node("D", Leaf("E"), Leaf("C")), Leaf("A")))
    }
  }
}
