;; ## Chapter 1 - Playthings
(ns reasoned-schemer.chapter-1
  (:use clojure.core.logic))

;; **10** - What is the value of
(run* [q]
      fail)

;; **11** - What is the value of
(run* [q]
      (== succeed q))

;; **12** - What is the value of
(run* [q]
      fail
      (== succeed q))

;; **13** - What value is associated with q in
(run* [q]
      succeed
      (== true q))

;; **14** - Then, what is the value of
(run* [q]
      succeed
      (== succeed q))

;; **15** - What value is associated with r in
(run* [r]
      succeed
      (== 'corn r))

;; **16** - What is the value of
(run* [r]
      succeed
      (== 'corn r))

;; **17** - What is the value of
(run* [r]
      fail
      (== 'corn r))

;; **18** - What is the value of
(run* [q]
      succeed
      (== fail q))

;; **22** - What is the value of
(run* [x]
      (let [x false]
        (== succeed x)))

;; **23** - What value is associate with q in
(run* [q]
      (fresh [x]
             (== succeed x)
             (== succeed q)))

;; **26** - What value is associated with q in
(run* [q]
      (fresh [x]
             (== x true)
             (== true q)))

;; **27** - What value is associated with q in
(run* [q]
      (fresh [x]
             (== x true)
             (== q true)))

;; **28** - What valid is associated with x in
(run* [x] succeed)

;; **29** - What is the value of
(run* [x]
      (let [x false]
        (fresh [x]
               (== true x))))

;; **30** - What value is associated with r in
(run* [r]
      (fresh [x y]
             (== (cons x (cons y '())) r )))

;; **31** - What value is associated with s in
(run* [s]
      (fresh [t u]
             (== (cons t (cons u '())) s)))

;; **32** - What value is associated with r in
(run* [r]
      (fresh [x]
             (let [y x]
               (fresh [x]
                      (== (cons y (cons x (cons y '()))) r)))))

;; **33** - What value is associated with r in
(run* [r]
      (fresh [x]
             (let [y x]
               (fresh [x]
                      (== (cons x (cons y (cons x '()))) r)))))

;; **34** - What is the value of
(run* [q]
      (== false q)
      (== true q))

;; **35** - What is the value of
(run* [q]
      (== false q)
      (== false q))

;; **36** - What value is associated with q in
(run* [q]
      (let [x q]
        (== true x)))

;; **37** - What value is associated with r in
(run* [r]
      (fresh [x]
             (== x r)))

;; **38** - What value is associated with q in
(run* [q]
      (fresh [x]
             (== true x)
             (== x q)))

;; **39** - What value is associated with q in
(run* [q]
      (fresh [x]
             (== x q)
             (== true x)))

;; **40** - Are q and x different variables in
(run* [q]
      (fresh [x]
             (== true x)
             (== x q)))

;; **41** - What is the value of
(cond
 false  true
 :else false)

;; **43** - Does
(cond
 false succeed
 :else fail)
;; succeed?

;; **44** - Does
(conde
 [fail succeed]
 [fail])
;; succeed?

;; **45** - Does
(conde
 [fail fail]
 [succeed])
;; succeed?

;; **46** - Does
(conde
 [succeed succeed]
 [fail])
;; succeed?

;; **47** - What is the value of
(run* [x]
      (conde
       [(== 'olive x) succeed]
       [(== 'oil x) succeed]
       [fail]))

;; **49** - What is the value of
(run 1 [x]
     (conde
      [(== 'olive x) succeed]
      [(== 'oil x) succeed]
      [fail]))

;; **50** - What is the value of
(run* [x]
      (conde
       [(== 'virgin x) fail]
       [(== 'olive x) succeed]
       [succeed succeed]
       [(== 'oil x) succeed]
       [fail]))

;; **52** - What is the value of
(run 2 [x]
     (conde
      [(== 'extra x) succeed]
      [(== 'virgin x) fail]
      [(== 'olive x) succeed]
      [(== 'oil x) succeed]
      [fail]))

;; **53** - What is associated with r in
(run* [r]
      (fresh [x y]
             (== 'split x)
             (== 'pea y)
             (== (cons x (cons y ())) r)))

;; **54** - What is the value of
(run* [r]
      (fresh [x y]
             (conde
              [(== 'split x)(== 'pea y)]
              [(== 'navy x)(== 'bean y)]
              [fail])
             (== (cons x (cons y ())) r)))

;; **55** - What is the value of
(run* [r]
      (fresh [x y]
             (conde
              [(== 'split x)(== 'pea y)]
              [(== 'navy x)(== 'bean y)]
              [fail])
             (== (cons x (cons y (cons 'soup ()))) r)))

;; **56** - Consider this very simple definition
(defn teacupo [x]
  (conde
   [(== 'tea x) succeed]
   [(== 'cup x) succeed]
   [fail]))

;; What is the value of
(run* [x]
      (teacupo x))

;; **57** - Also, what is the value of
(run* [r]
      (fresh [x y]
             (conde
              [(teacupo x)(== true y) succeed]
              [(== false x) (== true y)]
              [fail])
             (== (cons x (cons y ())) r)))

;; **58** - What is the value of
(run* [r]
      (fresh [x y z]
             (conde
              [(== y x)(fresh [x] (== z x))]
              [(fresh [x] (== y x)) (== z x)]
              [fail])
             (== (cons y (cons z ())) r)))

;; **59** - Then, what is the value of
(run* [r]
      (fresh [x y z]
             (conde
              [(== y x)(fresh [x] (== z x))]
              [(fresh [x] (== y x)) (== z x)]
              [fail])
             (== false x)
             (== (cons y (cons z ())) r)))

;; **60** - What is the value of
(run* [q]
      (let [a (== true q)
            b (== false q)]
        b))

;; **61** - What is the value of
(run* [q]
      (let [a (== true q)
            b (fresh [x]
                     (== x q)
                     (== false x))
            c (conde
               [(== true q) succeed]
               [(== false q)])]
        b))