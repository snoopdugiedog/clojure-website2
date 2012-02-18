(ns main
  (:use [jayq.core :only [$ inner]]
        [crate.core :only [html]]))

(defn before [$elem content]
  (.before $elem content))
(defn submit [$elem func]
  (.submit $elem func))

(defn ^:export add_task []
  (let [add_task ($ :#add_task)]
    (before add_task (html [:li "New Task"]))
    )
  false)

(defn ^:export message []
  (js/alert "Hello from clojurescript again"))


(defn ^:export startxthj []
  (submit ($ "#add_task form") add_task))

(set! (.-onload js/window) startxthj)

