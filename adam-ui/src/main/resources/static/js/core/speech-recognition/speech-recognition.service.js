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