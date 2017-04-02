angular
    .module('app.core')
    .controller('surveyController', function (surveyService,$log) {
            var vm = this;
            vm.questionCount = 1;
            vm.question = '';
            vm.answers = [''];

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
                    $log.info(response)
                });
            };

            vm.remove = function (i) {
                vm.answers.splice(i, 1);
            };

        }
    );