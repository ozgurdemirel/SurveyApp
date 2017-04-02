angular
    .module('app.core')
    .controller('surveyController',function () {
            var vm = this;
            vm.questionCount = 1;
            vm.question='';
            vm.answers = [''];

            vm.addQuestion = function () {
                vm.answers.push('');
            };

            vm.save = function () {
                console.log(vm.answers);
            };

            vm.remove = function (i) {
                vm.answers.splice(i,1);
            };

        }
    );