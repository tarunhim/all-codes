#!/bin/sh
code /Users/tarun/Documents/Shippigo-repositories/shippigo
sleep 2

# Bring focus to the newly opened VSCode window
osascript -e 'tell application "System Events" to tell process "Code" to set frontmost to true'

# Wait for the terminal to be ready
sleep 2

osascript -e 'tell application "System Events" to tell process "Code" to keystroke "`" using {control down, option down}'
osascript -e 'tell application "System Events" to tell process "Code" to key code 36'
sleep 2

# Send the command to the terminal
osascript -e 'tell application "System Events" to tell process "Code" to keystroke "npm run start-dev"'
osascript -e 'tell application "System Events" to tell process "Code" to key code 36'
