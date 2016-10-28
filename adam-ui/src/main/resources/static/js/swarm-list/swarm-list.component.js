angular
  .module('swarm.list')
  .component('swarmList', {
    templateUrl: 'js/swarm-list/swarm-list.template.html',
    controller: [
      '$window', 'Swarm', 'speechRecognition',
      function SwarmListController($window, Swarm, speechRecognition) {
        var self = this;
        speechRecognition.addCommand("show me *tag", function(words) {
          console.log(words);
          var phrase = /(.*)(nodes|containers)/.exec(words);
          if(phrase[2].match(/containers|nodes/gi)) {
            var id = findId(phrase[1]);
            if (phrase[2] === 'containers') {
              $window.location.assign('#!/swarms/' + id  + '/containers')
            } else if (phrase[2] ===  'nodes') {
              $window.location.assign('#!/swarms/' + id + '/nodes')
            }
          }
        });
        speechRecognition.start();
        self.swarms = Swarm.swarms();
        
        var initSocket = function() {
          var client = new SockJS("http://localhost:8080/adam-websocket");
          self.stomp = Stomp.over(client);
          self.stomp.connect({}, function() {
            self.stomp.subscribe('/topic/swarm/events', console.log);  
          });
        };
        initSocket();
        var findId = function(words) {
          var parts = words.split(' ');
          var candidates = {};
          for (var j = 0; j < parts.length; j++) {
            candidates[j] = [];
          }
          for (var i = 0; i < self.swarms.length; i++) {
            for (var j = 0; j < parts.length; j++) {
              if (self.swarms[i].name.includes(parts[j])) {
                candidates[j].push(self.swarms[i].id);
              }
            }
          }
          if (parts.length > 1) {
            var intersection = candidates[0].filter(function(n) {
              return candidates[1].indexOf(n) !== -1;
            })
            for (var i = 2; i < candidates.length; i++) {
              intersection = candidates[i].filter(function(n) {
                return intersection.indexOf(n) !== -1;
              });
            }
            if(intersection.length == 1) {
              return intersection[0];
            }
          } else {
            if (candidates[0].length == 1) {
              return candidates[0][0];
            }
          }
          return false;
        };
      }
    ]
  });