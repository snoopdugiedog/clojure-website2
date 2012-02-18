(ns website2.views.welcome
  (:require [website2.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage defpartial render]]
        [hiccup.core :only [html]]
        [hiccup.form-helpers :only [form-to label text-field submit-button]]
        [website2.models.task :only [add-task]]))

(defpage "/welcome" []
         (common/layout
           [:p "Welcome to website2"]))

(defpage "/my-page" []
  (common/site-layout
   [:h1 "Welcome to my site!"]
   [:p "Hope you like it"]
   [:a {:href "#" :onclick "main.message();"}
    "Suprise me"]))

(defpage "/submit" []
  (common/site-layout
    (form-to [:get "/hello"]
      [:input {:type "text" :name "name"}]
      [:input {:type "submit"}])))

(defpage "/hello" {name :name}
  (common/site-layout
    [:h1 "Hello"]
    [:h1 name]))

(defpartial task-form [{:keys [summary]}]
  (label "summary" "Summary: ")
  (text-field "summary" summary))

(defpage "/tasks" [:as task]
  (common/site-layout
   [:h1 "The Tasks"]
   [:ol
    (if (not-empty task)
      [:li (get task :summary)])
    [:li#add_task
     (form-to [:post "/tasks"]
              (task-form "")
              (submit-button "Add Task"))
     ]]
   ))

(defpage [:post "/tasks"] {:as task}
  (render "/tasks" (add-task task)))