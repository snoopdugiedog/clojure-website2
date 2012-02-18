(ns main
  (:use [jayq.core :only [$ inner]]))

(defn before [$elem content]
  (.before $elem content))

(defn ^:export add_task []
  (let [add_task ($ :#add_task)]
    (before add_task "<li>New Task</li>")
    ))

(defn ^:export message []
  (js/alert "Hello from clojurescript again"))
