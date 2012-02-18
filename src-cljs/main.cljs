(ns main
  (:use [jayq.core :only [$ inner]]))


(defn ^:export add_task []
  (js/alert "adding...")
  (let [tail ($ :#tail)]
    (inner tail "new task")))

(defn ^:export message []
  (js/alert "Hello from clojurescript again"))
