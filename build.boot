(set-env! :resource-paths #{"src"})

(require '[boot.git :refer [last-commit]]
         '[adzerk.bootlaces :refer :all])

(def +version+ "0.1.13")

(bootlaces! +version+)

(task-options!
 push {:repo           "deploy"
       :ensure-branch  "master"
       :ensure-clean   true
       :ensure-tag     (last-commit)
       :ensure-version +version+}
 pom  {:project        'degree9/bootlaces
       :version        +version+
       :description    "Degree9 boot configurations for Clojure libraries (forked from Adzerk)"
       :url            "https://github.com/degree9/bootlaces"
       :scm            {:url "https://github.com/degree9/bootlaces"}
       :license        {"Eclipse Public License" "http://www.eclipse.org/legal/epl-v10.html"}})
