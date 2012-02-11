(ns website2.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-js include-css html5]]))

(defn include-less [path]
  [:link {
          :rel "stylesheet/less"
          :type "text/css"
          :href path}])

(defpartial layout [& content]
            (html5
              [:head
               [:title "website2"]
               (include-css "/css/reset.css")]
              [:body
               [:div#wrapper
                content]]))

(defpartial site-layout [& content]
  (html5
   [:head
    [:title "my website2"]
    (include-js "/js/main.js")
    (include-less "/less/basic.less")
    (include-js "/js/less-1.2.1.min.js")
    ]
   [:body
    [:div#wrapper
     content]]))