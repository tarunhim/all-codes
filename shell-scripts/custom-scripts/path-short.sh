#!/bin/bash

if [ $# -eq 0 ]; then
  cd /Users/tarun/Documents
elif [ $1 = "shippi" ]; then
  cd /Users/tarun/Documents/Shippigo-repositories
elif [ $1 = "wms" ]; then
  cd /Users/tarun/Documents/WMS-REPOS
elif [ $1 = "gitlab" ]; then
  cd /Users/tarun/Documents/Git-lab-shippigo-repos
else
  echo "Invalid argument"
fi
