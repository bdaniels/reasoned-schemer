;; ## Chapter 1 - Playthings
(ns reasoned-schemer.chapter-1
  (:use clojure.core.logic))

;; ... skipping past the introduction

;; What is the value of
(run* [q]
      fail)

;; What is the value of
(run* [q]
      (== succeed q))

;; What is the value of
(run* [q]
      fail
      (== succeed q))

;; What value is associated with q in
(run* [q]
      succeed
      (== succeed q))

;; Then, what is the value of
(run* [q]
      succeed
      (== succeed q))

;; What value is associated with r in
(run* [r]
      succeed
      (== 'corn r))

;; What is the value of
(run* [r]
      succeed
      (== 'corn r))

;; What is the value of
(run* [r]
      fail
      (== 'corn r))

;; What is the value of
(run* [q]
      succeed
      (== fail q))

