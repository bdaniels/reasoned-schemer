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

;; ... skipping the "does" questions

;; What is the value of
(run* [x]
      (let [x fail]
        (== succeed x)))

;; What value is associate with q in
(run* [q]
      (fresh [x]
             (== succeed x)
             (== succeed q)))

;; ... skip the next two

;; What value is associated with q in
(run* [q]
      (fresh [x]
             (== x succeed)
             (== succeed q)))

;; What value is associated with q in
(run* [q]
      (fresh [x]
             (== x succeed)
             (== q succeed)))

;; What valid is associated with x in
(run* [x] succeed)

;; What is the value of
(run* [x]
      (let [x fail]
        (fresh [x]
               (== succeed x))))

;; What value is associated with r in
(run* [r]
      (fresh [x y]
             (== (cons x (cons y '())) r )))

;; What value is associated with s in
(run* [s]
      (fresh [t u]
             (== (cons t (cons u '())) s)))

;; What value is associated with r in
(run* [r]
      (fresh [x]
             (let [y x]
               (fresh [x]
                      (== (cons y (cons x (cons y '()))) r)))))

;; What value is associated with r in
(run* [r]
      (fresh [x]
             (let [y x]
               (fresh [x]
                      (== (cons x (cons y (cons x '()))) r)))))

;; What is the value of
(run* [q]
      (== fail q)
      (== succeed q))

;; What is the value of
(run* [q]
      (== fail q)
      (== fail q))

;; What value is associated with q in
(run* [q]
      (let [x q]
        (== succeed x)))

;; What value is associated with r in
(run* [r]
      (fresh [x]
             (== x r)))

;; What value is associated with q in
(run* [q]
      (fresh [x]
             (== succeed x)
             (== x q)))

;; What value is associated with q in
(run* [q]
      (fresh [x]
             (== x q)
             (== succeed x)))

;; Are q and x different variables in
(run* [q]
      (fresh [x]
             (== succeepd x)
             (== x q)))

;; What is the value of
(cond
 false  true
 :else false)

;; Does
(cond
 false succeed
 :else fail)
;; succeed?

;; Does
(conde
 [fail succeed]
 [fail])
;; succeed?

;; Does
(conde
 [fail fail]
 [succeed])
;; succeed?

;; Does
(conde
 [succeed succeed]
 [fail])
;; succeed?

;; What is the value of
(run* [x]
      (conde
       [(== 'olive x) succeed]
       [(== 'oil x) succeed]
       [fail]))

;; What is the value of
(run 1 [x]
     (conde
      [(== 'olive x) succeed]
      [(== 'oil x) succeed]
      [fail]))

;; What is the value of
(run* [x]
      (conde
       [(== 'virgin x) fail]
       [(== 'olive x) succeed]
       [succeed succeed]
       [(== 'oil x) succeed]
       [fail]))

;; What is the value of
(run 2 [x]
     (conde
      [(== 'extra x) succeed]
      [(== 'virgin x) fail]
      [(== 'olive x) succeed]
      [(== 'oil x) succeed]
      [fail]))

;; What is associated with r in
(run* [r]
      (fresh [x y]
             (== 'split x)
             (== 'pea y)
             (== (cons x (cons y ())) r)))

;; What is the value of
(run* [r]
      (fresh [x y]
             (conde
              [(== 'split x)(== 'pea y)]
              [(== 'navy x)(== 'bean y)]
              [fail])
             (== (cons x (cons y ())) r)))

;; What is the value of
(run* [r]
      (fresh [x y]
             (conde
              [(== 'split x)(== 'pea y)]
              [(== 'navy x)(== 'bean y)]
              [fail])
             (== (cons x (cons y (cons 'soup ()))) r)))

;; Consider this very simple definition
(defn teacupo [x]
  (conde
   [(== 'tea x) succeed]
   [(== 'cup x) succeed]
   [fail]))

;; What is the value of
(run* [x]
      (teacupo x))

;; Also, what is the value of
(run* [r]
      (fresh [x y]
             (conde
              [(teacupo x)(== true y) succeed]
              [(== false x) (== true y)]
              [fail])
             (== (cons x (cons y ())) r)))

;; What is the value of
(run* [r]
      (fresh [x y z]
             (conde
              [(== y x)(fresh [x] (== z x))]
              [(fresh [x] (== y x) (== z x))]
              [fail])
             (== (cons y (cons z ())) r)))
; TODO email this to DNolan to see if this is a bug

;; Then, what is the value of
(run* [r]
      (fresh [x y z]
             (conde
              [(== y x)(fresh [x] (== z x))]
              [(fresh [x] (== y x) (== z x))]
              [fail])
             (== false x)
             (== (cons y (cons z ())) r)))

;; What is the value of
(run* [q]
      (let [a (== true q)
            b (== false q)]
        b))