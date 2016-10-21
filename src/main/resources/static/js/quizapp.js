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
                    "data" : "answer"
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
	$(document).on('click', '#getQuizzes', function(){
		$('#quiztbody').empty();
		$('#quizthead').empty();
		$('#seeQuizQuestions').hide();
		$.ajax({
	    	url: '/seequizzes',
	    	dataType: 'json',
	    	success: function(data){
	    		
	    		$.each(data, function(i, d) {
	    			   var row='<tr>';
	    			   $.each(d, function(j, e) {
	    			      row+='<td>'+e+'</td>'; 
	    			   });
	    			   row+='<td><button class="btn btn-info" id="seeQuestionsButton">See questions</button></td><td><button id="deleteQuiz" class="btn btn-danger">Delete Quiz</button></td>';
	    			   	
	    			   row+='</tr>';
	    			   
	    			   $('#quizTable #quiztbody').append(row);
	    			   
	    			});	
				
	    	},
	    	error: function(data) {
	    		alert('Oops! Error');
	    	}
		});
		$table = "<tr><td><b>ID</b></td><td><b>CATEGORY</b></td><td><b>DIFFICULTY</b></td><td><b>DESCRIPTION</b></td><td><b>SEE QUESTIONS</b><td><b>DELETE</b></td></td></tr>"
		$('#quizthead').append($table);
		$('#quizTable').show();	
		$('#seeQuizzes').show();
	});
	
	
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
	
	
});

