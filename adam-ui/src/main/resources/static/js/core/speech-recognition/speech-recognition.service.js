/*******************************************************************************
 * Copyright [2016] [Quirino Brizi (quirino.brizi@gmail.com)]
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
angular
  .module('core.speech-recognition')
  .factory('speechRecognition', ['$rootScope', function($rootScope) {
    return {
      commands: {},
      addCommand: function(phrase, callback) {
        var command = {};
        // Wrap annyang command in scope apply
        command[phrase] = function(args) {
          $rootScope.$apply(callback(args));
        };
        // Extend our commands list
        angular.extend(this.commands, command);
        // Add the commands to annyang
        annyang.addCommands(command);
        console.debug('added command "' + phrase + '"', this.commands);
      },
      addCommandWithRegex: function(phrase, regex, callback) {
        var command = {};
        // Wrap annyang command in scope apply
        command[phrase] = {
          'regex': regex,
          'callback': function(args) {
            $rootScope.$apply(callback(args));
          }
        };
        // Extend our commands list
        angular.extend(this.commands, command);
        // Add the commands to annyang
        annyang.addCommands(command);
        console.debug('added command "' + phrase + '"', this.commands);
      },
      start: function() {
        annyang.addCommands(this.commands);
        annyang.debug(true);
        if(!annyang.isListening()) {
       		annyang.start();
      	}
      }
    };
  }]);