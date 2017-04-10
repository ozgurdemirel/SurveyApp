angular
    .module('app.core')
    .controller('surveyController', function (surveyService,$log,growl) {
            var vm = this;
            vm.questionCount = 1;
            vm.question = '';
            vm.answers = [''];

            vm._addAlert = function (msg) {
              growl.success(msg,{title: 'Seems good!'});
             // growl.warning(msg,{title: 'Warning!'});
              // growl.error('This is error message.',{title: 'Error!'});
              // growl.success('This is success message.',{title: 'Success!'});
              // growl.info('This is an info message.',{title: 'Info!'});
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
                    vm._addAlert('Question added successfully');
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