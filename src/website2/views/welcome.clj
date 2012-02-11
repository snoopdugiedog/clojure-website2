(ns website2.views.welcome
  (:require [website2.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(defpage "/welcome" []
         (common/layout
           [:p "Welcome to website2"]))

(defpage "/my-page" []
  (common/site-layout
   [:h1 "Welcome to my site!"]
   [:p "Hope you like it"]
   [:a {:href "" :onclick "alert('foo');"}
    "Suprise me"]))