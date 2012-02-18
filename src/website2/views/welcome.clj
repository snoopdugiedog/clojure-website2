(ns website2.views.welcome
  (:require [website2.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]
        [hiccup.form-helpers :only [form-to]]))

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

(defpage "/tasks" []
  (common/site-layout
   [:h1 "Welcome to my site!"]
   [:p "Hope you like it"]
   [:a {:href "#" :onclick "main.add_task();"}
    "Suprise me"]
   [:p#tail "original"]))
