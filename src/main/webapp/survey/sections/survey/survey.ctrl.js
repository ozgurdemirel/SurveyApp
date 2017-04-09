angular
    .module('app.core')
    .controller('surveyController', function (surveyService,$log) {
            var vm = this;
            vm.questionCount = 1;
            vm.question = '';
            vm.answers = [''];
            vm.alerts = [];

            vm._addAlert = function (msg) {
              vm.alerts = [];
              vm.alerts.push({'msg' : msg });
            };

            vm.closeAlert = function (index) {
                vm.alerts.splice(index,1);
            };

            vm.addQuestion = function () {
                vm.answers.push('');
            };

            vm.save = function () {
                var data = {
                    'questionText': vm.question,
                    'choices': []
                };
                for (var i = 0; i < vm.answers.length; i++)
                    data.choices.push({
                        'choice': vm.answers[i]
                    });
                surveyService.save(data).then(function (response) {
                    $log.info(response);
                    vm._addAlert('question added successfully');
                    vm._reset();
                });
            };

            vm._reset = function () {
              vm.answers = [''];
              vm.question = '';
            };

            vm.remove = function (i) {
                vm.answers.splice(i, 1);
            };

        }
    );