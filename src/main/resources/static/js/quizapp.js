$(document).ready(function(){
	$('#editItems').hide();
	$('#getQuestions').click(function(){
		$('#tbody').empty();
		$('#thead').empty();
		$('#editItems').hide();
		$.ajax({
	    	url: '/getquestions',
	    	dataType: 'json',
	    	success: function(data){
	    	
	    		$.each(data, function(i, d) {
	    			   var row='<tr>';
	    			   $.each(d, function(j, e) {
	    			      row+='<td>'+e+'</td>';
	    			      
	    			   });
	    			   
	    			   row+='<td><button class="btn btn-warning" id="editButton">Edit</button></td><td><button class="btn btn-danger" id="deleteButton">Delete</button></td>';
	    			   	
	    			   row+='</tr>';
	    			   
	    			   $('#table tbody').append(row);
	    			   
	    			});	
				
	    	},
	    	error: function(data) {
	    		alert('Oops! Error');
	    	}
		});
		$table = "<tr><td><b>ID</b></td><td><b>ANSWER</b></td><td><b>A</b></td><td><b>B</b></td><td><b>C</b></td><td><b>D</b></td><td><b>CATEGORY</b></td><td><b>DIFFICULTY</b></td><td><b>QUESTION</b></td><td></td><td></td></tr>"
		$('#thead').append($table);
		$('#table').show();
});
	
	$(document).on('click', '#addQuestions',function(){
		console.log("clicked");
		
		window.location.href='/setquestions';
		var questions = JSON.parse(localStorage.getItem('questiondata'));
	});
	$(document).on('click', '#goBack', function(){
		console.log("clicked");
		window.location.href='/home';
	});
	
	$(document).on('click', '#getQuizzes', function(){
		$('#askQuizType').hide();
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
		$('#table').hide();
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
		
		$.ajax({
			url: '/generatequiz/'+cid+'/'+did,
			type: 'GET',
			dataType : 'json',
			success : function(data) {
				var temp = {};
				temp = data;
				console.log(temp);
				localstorage.setItem("questions", data);
				console.log(data[0].questionName);
			},
			error: function() {
				alert('Oops error!');
			}
		});
		
		var questionobject = localStorage.getItem("questions");
		console.log(questionobject);
		$.ajax({
			url: '/savequiz/'+cid+'/'+did,
			type: 'POST',
			data : JSON.stringify(questionobject),
			dataType : 'json',
			success: function() {
				alert("values inserted");
			},
			error: function() {
				alert('Oops error!');
			}
		})
		
	});
	
	

});

