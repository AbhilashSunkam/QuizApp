$(document).ready(function(){
	$('#editItems').hide();
	$('#editBody').hide();
	$('#getQuestions').click(function() {
		$('#editItems').hide();
		$('#editBody').show();
		$.ajax({
			url: '/getquestions',
	    	dataType: 'json',
	    	success: function(data){
	    		addToTable(data);
	    	}
		});
	});
	
	function addToTable(data) {
		var table = $('#example').dataTable({
			"bAutoWidth" : false,
            "bDestroy": true,
            "aaData" : data,
            "columns" : [ {
            		"data" : "id"
                }, {
                	"data" : "answer"
                }, {
                    "data" : "answer1"
                }, {
                    "data" : "answer2"
                }, {
                    "data" : "answer3"
                }, {
                    "data" : "answer4"
                }, {
                    "data" : "categoryId"
                }, {
                    "data" : "difficultyId"
                }, {
                    "data" : "questionName"
                }, {
                mRender: function (data, type, row) {
                    return '<button class="btn btn-warning" id ="editButton" data-id="' + row[0] + '">EDIT</button>'
                }
                }, {
                mRender: function (data, type, row) {
                    return '<button class="btn btn-danger" id="deleteButton" data-id="' + row[0] + '">DELETE</button>'
                }
                }, ]
            
            })
		}
		
	$(document).on('click', '#addQuestions',function(){
		console.log("clicked");
		window.location.href='/setquestions';
		var questions = JSON.parse(localStorage.getItem('questiondata'));
	});
	
	$(document).on('click', '#goBack', function(){
		console.log("clicked");
		window.location.href='/home';
	});
	
	$(document).on('click','#deleteButton',function(){
		var id = $(this).parents('tr:first').find('td:first').text();
		console.log(id);
		$.ajax({
		    url: '/deletequestion/'+id,
		    type: 'DELETE',
		    success: function() {
		    }, 
		    error: function() {
		    }
		});
		$(this).closest('tr').remove();
	});
	
	$(document).on('click','#editButton',function(){
		var id = $(this).parents('tr:first').find('td:first').text();
		localStorage.setItem("id", id);
			$.ajax({
				url: '/getquestion/'+id,
				type: 'GET',
				dataType: 'json',
				success: function(data) { 
					$('#qname').val(data[0].questionName);
					$('#ans1').val(data[0].answer1);
					$('#ans2').val(data[0].answer2);
					$('#ans3').val(data[0].answer3);
					$('#ans4').val(data[0].answer4);
					$('input[name=answer]').val(data[0].answer);
					$('#selectCategory').val(data[0].categoryId);
					$('#selectDifficulty').val(data[0].difficultyId);
				},
				error: function(data) {
					alert('Oops Error!');
				}
			});
		$('#example_wrapper').hide();
		$('#editItems').show();
			
	});
		
	$(document).on('click','#editSubmit', function(){
		var object = localStorage.getItem("id");
		console.log(object);
		console.log('hello');
		$.ajax({
		    url: '/editquestion/'+object,
		    type: 'PUT',
		    data: JSON.stringify( {
		    		id : object,
		    		questionName : $('#qname').val(),
		    		answer1 : $('#ans1').val(),
		    		answer2 : $('#ans2').val(),
		    		answer3 : $('#ans3').val(),
		    		answer4 : $('#ans4').val(),
		    		answer  : $('input[name="myRadio"]:checked', '#myForm').val(),
		    		categoryId : $('#selectCategory').val(),
		    		difficultyId : $('#selectDifficulty').val()}
		    		),
		    dataType: 'json',
		    contentType: "application/json",
		    success: function() {
		    	console.log('success');
		    }, 
		    error: function() {
		    }
		});
		
	});
	
	$(document).on('click', '#generateQuiz', function(){
		window.location.href="/generatequiz";
		
	});
	
	$(document).on('click', '#saveQuiz', function(){
		var cid = $('#selectCategory').val();
		var did = $('#selectDifficulty').val();
		var quizdescription = $('#description').val();
		$.ajax({
			url: '/generatequiz/'+cid+'/'+did,
			type: 'POST',
			data: quizdescription,
			dataType: 'json',
			contentType: 'application/json',
			success : function() {
				console.log("Successfully generated");
			},
			error: function() {
			}
		});
		
		
	});
	
	//Seeing the quizzes	
	$('#quizthead').hide();
	$(document).on('click', '#getQuizzes', function(){
		$.ajax({
	    	url: '/seequizzes',
	    	dataType: 'json',
	    	success: function(data){
				addToQuizzes(data);
	    	},
	    	error: function(data) {
	    	}
		});
		$('#quizthead').show();
		$('#seeQuizQuestions').hide();
		$('#seeQuizzes').show();
	});
	
	function addToQuizzes(data) {
		var table = $('#quizTable').dataTable({
			"bAutoWidth" : false,
            "bDestroy": true,
            "aaData" : data,
            "columns" : [ {
            		"data" : "id"
                }, {
                	"data" : "category_id"
                }, {
                    "data" : "difficulty_id"
                }, {
                    "data" : "description"
                }, {
                mRender: function (data, type, row) {
                    return '<button class="btn btn-info" id="seeQuestionsButton" data-id="' + row[0] + '">SEE QUESTIONS</button>'
                }
                }, {
                mRender: function (data, type, row) {
                    return '<button class="btn btn-danger" id="deleteQuiz" data-id="' + row[0] + '">DELETE</button>'
                }
                }, ]
            
            })
	}
	
	
	
	
	
	// see question
	
	$(document).on('click','#seeQuestionsButton', function() {
		var id = $(this).parents('tr:first').find('td:first').text();
		var quizName = $(this).parents('tr:first').find('td:eq(3)').text();
		$('#quizName').empty();
		$('#seeQuizzes').hide();
		$('#questionbody').empty();
		$('#questionhead').empty();
		$('#seeQuizQuestions').show();
		$('#quizName').append(quizName);
		$.ajax({
			url : '/viewquestions/'+id,
			dataType : 'json',
			success : function(data) {
				
				$.each(data, function(i, d) {
	    			   var row='<tr>';
	    			   $.each(d, function(j, e) {
	    			      row+='<td>'+e+'</td>';
	    			      
	    			   });
	    			   	
	    			   row+='</tr>';
	    			   
	    			   $('#quizquestions #questionbody').append(row);
	    			   
	    			});	
				
			},
			error : function(data) {
				alert('oops error');
			}
			
		});
		$table = "<tr><td><b>ID</b></td><td><b>ANSWER</b></td><td><b>A</b></td><td><b>B</b></td><td><b>C</b></td><td><b>D</b></td><td><b>CATEGORY</b></td><td><b>DIFFICULTY</b></td><td><b>QUESTION</b></td></tr>"
			$('#questionhead').append($table);
	});
	
	$(document).on('click', "#deleteQuiz" , function(){
		var id = $(this).parents('tr:first').find('td:first').text();
		$.ajax({
		    url: '/deletequiz/'+id,
		    type: 'DELETE',
		    success: function() {
		    }, 
		    error: function() {
		    }
		});
		$(this).closest('tr').remove();
	});
	
	
	// QUIZ PLAY
	$(document).on('click', '#quizPlay', function(){
		var category_id = $('#selectCategory').val();
		var difficulty_id = $('#selectDifficulty').val();
		localStorage.setItem("cid", category_id);
		localStorage.setItem("did", difficulty_id);
		// getting a quiz randomly
		$.ajax({
			url : '/quizplay/'+category_id+'/'+difficulty_id,
			type : 'GET',
			dataType : 'json',
			success : function(data) {
				var quiz_id = data[0].id;
				localStorage.setItem("quiz_id", quiz_id);
				console.log(data[0].id);
			},
			error : function() {
			}
		});
		
		window.location.href='/quizquestions';
	});
	
	$(document).on('click', '#startPlayBtn', function() {
		$('#startPlayBtn').hide();
		$('#userQuizPlay').show();
		$('#quizdetails').show();
		$('#progress').append('<h2 style="color:green;"> : Progress</h2>');
		var cId = localStorage.getItem("cid");
		var dId = localStorage.getItem("did");
		if (cId == 1) {
			$('#category').append("general");
		} else if ( cId == 2 ) {
			$('#category').append("sports");
		} else {
			$('#category').append("geography");
		}
		$('#difficulty').append(dId);
		
		makeQuestionEmpty();
		
		// getting questions from the selected quiz
		var qId = localStorage.getItem("quiz_id");
		$.ajax({
			url : '/viewquestions/'+qId,
			type : 'GET',
			dataType : 'json',
			success : function(data) {
				var question = 0;
				var score = 0;
				if(data.length > 0) {
					questionDisplay(data, question, score);
				} else {
					$('#questionAnswer').hide();	
				}	
			},
			error : function() {
			}
		});
			
	});
	
	function makeQuestionEmpty() {
		$('#quizQuestionName').empty();
		$('#quizQuestionAnswer1').empty();
		$('#quizQuestionAnswer2').empty();
		$('#quizQuestionAnswer3').empty();
		$('#quizQuestionAnswer4').empty();
	}
	// displaying the question and changing the question on clicking next button and finally calculating the score.
	var flag=0;
	function questionDisplay(data, question, score) {
		
		$('#quizDisplay button').prop('disabled', false);
		$('#quizDisplay button').removeClass('btn-danger').addClass('btn-primary');
		$('#quizDisplay button').removeClass('btn-success').addClass('btn-primary');
		$('#qNumber').empty();
		if (question < data.length) {
			makeQuestionEmpty();
			$('#qNumber').append(question+1);
			$('#quizQuestionName').append(data[question].questionName);
			$('#quizQuestionAnswer1').append(data[question].answer1);
			$('#quizQuestionAnswer2').append(data[question].answer2);
			$('#quizQuestionAnswer3').append(data[question].answer3);
			$('#quizQuestionAnswer4').append(data[question].answer4);
		} else {
			flag++;
			$('#questionAnswer').hide();
			$('#progress').empty();
			$('#quizdetails').empty();
			$('#progress').append('<h2 style="color:red;"> : Finished </h2>');
			$('#score').append("<h2><h2 style='color:purple'>You scored : <label style='color:blue'>"+score+"</label> out of "+question+" </h2></h2><button class='btn btn-warning' id='playAnotherQuiz'>Play another quiz</button>");
		}
		
		$(document).on("click", "#quizDisplay button", function(e){
		    var selectedAns = $(this).val();
		    var correctAns = data[question].answer;
		    
		    if(selectedAns===data[question].answer) {
		    	$(this).removeClass('btn-primary');
		    	$(this).addClass('btn-success');
		    	$('#quizDisplay button').prop('disabled', true);
		    	score = score+1;
		    	console.log(score);
		    	console.log("hello");
		    } else {
		    	$(this).removeClass('btn-primary');
		    	$(this).addClass('btn-danger');
		    	$('#quizDisplay :input[value='+correctAns+']').removeClass('btn-primary').addClass('btn-success');
		    	$('#quizDisplay button').prop('disabled', true);
		    }	    
		});
		
		$(document).on("click", "#continue", function(){
			question = question+1;
			if (flag == 0) {
			questionDisplay(data, question, score);
			}
		});
		
	}
	
	$(document).on('click','#playAnotherQuiz', function(){
		window.location.href = '/quizplay';
	});
	
	$(document).on('click','#admin', function() {
		window.location.href = '/home';
	});
	
	$(document).on('click','#backToHome', function(){
		window.location.href = '/';
	});
	
	$(document).on('click', '#user' , function() {
		window.location.href = '/quizplay';
	});
	
	
});

