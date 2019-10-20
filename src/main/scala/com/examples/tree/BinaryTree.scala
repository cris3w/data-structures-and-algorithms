package com.examples.tree

sealed trait BinaryTree {

  // P149-6.2: height of the longest branch
  def height: Int = {
    def loop(btree: BinaryTree): Int =
      btree match {
        case Empty => 0
        case Leaf(_) => 1
        case Node(_, left, right) =>
          Math.max(loop(left), loop(right)) + 1
      }
    loop(this)
  }

  // P149-6.2: number of nodes
  def nodes: Int = {
    def loop(btree: BinaryTree): Int =
      btree match {
        case Empty => 0
        case Leaf(_) => 1
        case Node(_, left, right) =>
          loop(left) + loop(right) + 1
      }
    loop(this)
  }

  // P149-6.2: number of nodes that are leaves
  def leaves: Int = {
    def loop(btree: BinaryTree): Int =
      btree match {
        case Empty => 0
        case Leaf(_) => 1
        case Node(_, left, right) =>
          loop(left) + loop(right)
      }
    loop(this)
  }

  // P149-6.2: mirror image
  def mirror: BinaryTree = {
    def loop(btree: BinaryTree): BinaryTree =
      btree match {
        case Empty => Empty
        case Leaf(value) => Leaf(value)
        case Node(value, left, right) =>
          Node(value, loop(right), loop(left))
      }
    loop(this)
  }
}

case class Node(value: String, left: BinaryTree, right: BinaryTree) extends BinaryTree
case class Leaf(value: String) extends BinaryTree
case object Empty extends BinaryTree
