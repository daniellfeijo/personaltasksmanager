// gulpfile.js
// WebCore folder will be build at WebContent
var gulp = require('gulp'),
    imagemin = require('gulp-imagemin'),
    clean = require('gulp-clean'),
    concat = require('gulp-concat'),
    htmlReplace = require('gulp-html-replace'),
    uglify = require('gulp-uglify'),
    cssmin = require('gulp-cssmin');

// tarefa principal que chama todas as outras
gulp.task('WebContent', ['copy-task-list-resources', 'copy-task-list-view'], function() {
    gulp.start('build-task');
});

// clean WebContent/resources/task
gulp.task('clean-task-resources', function() {
    return gulp.src('../../personaltasksmanager/WebContent/resources/task')
        .pipe(clean({force: true}));
});


gulp.task('copy-task-list-resources', ['clean-task-resources'], function(){
    return gulp.src('../../WebCore/resources/task/**/*')
        .pipe(gulp.dest('../../personaltasksmanager/WebContent/resources/task'));
});

// clean WebContent/WEB-INF/views/task
gulp.task('clean-task-view', function() {
    return gulp.src('../../personaltasksmanager/WebContent/WEB-INF/views/task')
        .pipe(clean({force: true}));
});

gulp.task('copy-task-list-view', ['clean-task-view'], function(){
    return gulp.src('../../WebCore/WEB-INF/views/task/**/*')
        .pipe(gulp.dest('../../personaltasksmanager/WebContent/WEB-INF/views/task'));
});

// concat js files
gulp.task('concat-js-task-list', function() {
    return gulp.src(['../../personaltasksmanager/WebContent/resources/external/jQuery-v1.12.2/jquery.js',
            '../../personaltasksmanager/WebContent/resources/external/bootstrap-3.3.6-dist/js/bootstrap.min.js',
            '../../personaltasksmanager/WebContent/resources/task/list/js/task-list.js'])
        .pipe(concat('task-list.min.js'))
        .pipe(uglify())
        .pipe(gulp.dest('../../personaltasksmanager/WebContent/resources/task/list/js'))
});

gulp.task('clean-after-concat-js-task-list', ['concat-js-task-list'], function() {
    gulp.src(['../../personaltasksmanager/WebContent/resources/task/list/js/task-list.js'])
        .pipe(clean({force: true}));
});

gulp.task('html-replace-task-list', function() {
    gulp.src('../../personaltasksmanager/WebContent/WEB-INF/views/task/list/*.jsp')
        .pipe(htmlReplace({
            js: 'resources/task/list/js/task-list.min.js'
        }))
        .pipe(gulp.dest('../../personaltasksmanager/WebContent/WEB-INF/views/task/list'));
});


gulp.task('build-task', ['html-replace-task-list', 'clean-after-concat-js-task-list'], function() {

});
