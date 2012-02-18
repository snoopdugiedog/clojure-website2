(ns main
  (:use [jayq.core :only [$ inner]]
        [crate.core :only [html]]))

(defn before [$elem content]
  (.before $elem content))

(defn ^:export add_task []
  (let [add_task ($ :#add_task)]
    (before add_task (html [:li "New Task"]))
    ))

(defn ^:export message []
  (js/alert "Hello from clojurescript again"))
