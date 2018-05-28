//var lcUrl = "http://172.16.10.155:8090/";
var lcUrl = "http://localhost:8090/";
$(function () {
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
	xhr.setRequestHeader(header, token);
});
});

var appmain = {
	initialize : function() {
		this.bindEvents();
	},
	bindEvents : function() {
		lcFuntion = "bindEvents";
		console.log("Function run : " + lcFuntion);
		//		        this.onDeviceReady();
		document.addEventListener('deviceready', this.onDeviceReady, false);
	},
	onDeviceReady : function() {
		lcFuntion = "onDeviceReady";
		console.log("Function run : " + lcFuntion);
		//		        $('#form').submit(false);
		$('form').submit(function(ev) {
//			console.log("the form has submit")
			ev.preventDefault();
		});
	},
	CrudView : function(Obj) {
		lcFuntion = "CrudView";
		console.log("Function run : " + lcFuntion);
		$("#ModalCrud").empty();
		appmain.GetAjaxServ("GET",  $(Obj).data('itemid'), $(Obj).data('url'), function(output) {
//			lcmethod, lcdata, lcadd, handleData
//			data-item="${list.id}" ="viewOrder"
			$("#ModalCrud").append(output);
			$("#ModalCrud").show();
			$('.selectpicker').selectpicker();
			 $(document).ajaxStart(function() { Pace.restart(); });
			 $('form').submit(function(ev) {
						var form = $(this)[0];
						var mydata = new FormData(form);
						var pagetype = $(this).data('form');
						if($(this).attr('action') == "add-event"){
							 var lcDetItem, data = {},lcary = [];
								$('#eventIt :selected').each(function(i, selected){ 
									Mainid = $(selected).data('id') 
									MainPrice = $(selected).data('price')
									MainidEvent = $(selected).data('idevent') 									
//									viSet = ($("#eveset").val() / 100) * viPrice;
//									viPrice = MainPrice - viSet;
									 lcary.push({ "id":Mainid, "idevent" : MainidEvent,"iditem": $(selected).val(),"eveprice":  MainPrice });
								});
//							console.log(JSON.stringify(lcary))
//							mydata.append('eventItem', JSON.stringify(lcary));
//									$('.eventItem').val(JSON.stringify(lcary))
//							console.log(JSON.stringify(mydata))
								 lcDetItem = { "eventItem": lcary };
								 serialized = $(this).serializeArray();
								 for (s in serialized) {
								 data[serialized[s]['name']] = serialized[s]['value']
								 }											
							  $.extend(true, data, lcDetItem);
								mydata = JSON.stringify(data)
								console.log("the data is :" + JSON.stringify(mydata))
//								appmain.GetAjaxUpload("POST", mydata, $(this).attr('action'), function(output) {
								appmain.GetAjaxJson("POST", mydata, $(this).attr('action'), function(output) {
									appmain.ProcessData(output,pagetype);
								});
						}
						else{									
							appmain.GetAjaxUpload("POST", mydata, $(this).attr('action'), function(output) {
								appmain.ProcessData(output,pagetype);
							});
						}
						ev.preventDefault();
					});
			
			$("form input:text").first().focus();
				//			data = {};
				//			$('form').submit(function(ev) {
				//				serialized = $(this).serializeArray()
				//				for (s in serialized) {
				//					data[serialized[s]['name']] = serialized[s]['value']
				//				}
				//				mydata = JSON.stringify(data)
				//				console.log("the data is :" + mydata)
				//				appmain.GetAjaxServ("POST", mydata, "add-product", function(output) {
				//					
				//					console.log("data from server :"+JSON.stringify(output));
				//				});
				//				ev.preventDefault();
				//			});			
		});

	},ProcessData : function(Obj,lcPage){ //lcmsg,lcbody,lckode
		lcFuntion = "ProcessData";
		console.log("Function run : " + lcFuntion);
//		console.log("data from server :"+Obj);
//		console.log("data response :"+JSON.stringify(Obj) )
//		console.log("data response :"+Obj )
		
		console.log(lcPage)
		
		if(lcPage == "direct"){
			$('form')[0].reset();	
		}else{
			window.location.href = $(location).attr('href'); 
		}
//		
		$('.filter-option').text('Nothing selected')
		$("form input:text").first().focus();
//		alert("01")
//		lcArray = JSON.parse(Obj)
		
		lcArray = JSON.parse(Obj)
//		alert("02")
		var lcCode = ''; //$(lcArray.rsltcode);//.toString().substr(0,2);
		var lcMsg = '';//$(lcArray.rsltmsg);
//		alert("03")
	
			$.each(lcArray, function (name, value) {
				if(name == 'rsltcode'){
					lcCode = String(value);	
					return
				}else if (name == 'rsltmsg'){
					lcMsg = String(value);	
					return
				}				
//				lcMsg = String(value);
			});
//		alert("04")
		
		
		var lcclass,lcClick,lcimg;
		if(lcCode.toString().substr(0,2) == 'RE'){
				lcclass = "errorbox"
					lcimg="error.png"
						lcClick = "getClose(this)"
			}else{
					lcClick = "getClose(this)"
					lcclass = "successbox"
					lcimg="check.png"
					}

		$('<div class="notify '+lcclass+'" onclick="'+lcClick+'">'
			+'<h1>'+lcMsg+'!</h1>'
			+' <span class="alerticon blink"><img src="/images/'+lcimg+'" alt="checkmark" /></span>'
			+' <p>'+lcMsg+'.</p> </div>').prependTo('.mainnotif');		
		
		 $('#message').fadeIn(350, function(){ 
			  $('#message').show();
		  });

		// $("#ModalCrud").hide();
//		$("select option:first-child").attr("selected", "selected");
		
	},ClosePage : function(Obj) {
		lcFuntion = "ClosePage";
		console.log("Function run : " + lcFuntion);
		lcpage = $(Obj).data('page');
		lcdiv = $("#" + lcpage);
		lcdiv.hide();
	},
	GetAjaxServ : function(lcmethod, lcdata, lcadd, handleData) {
		lcFuntion = "GetAjaxServ";
		console.log("Function run : " + lcFuntion);
		$('#loader').show();
		$.ajax({
			type : lcmethod,
			url : lcUrl + lcadd,
			data : {"dataId":lcdata}, //JSON.stringify(lcdata)
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json"); // contentType: "application/x-www-form-urlencoded; charset=UTF-8", //sending
			//		                $('#loader').show();
			},
			success : function(response) {
				
			
				handleData(response);
			}, //timeout:3000,
			error : function(jqXhr, textStatus, errorThrown) {
				getError(jqXhr)
			}
		});
	},GetAjaxUpload : function(lcmethod, lcdata, lcadd, handleData) {
		lcFuntion = "GetAjaxUpload";
		console.log("Function run : " + lcFuntion);
	    $.ajax({
	        type: lcmethod,
	        enctype: 'multipart/form-data',
	        url: lcUrl + lcadd, //"http://localhost:8080/set-upload",
	        data: lcdata,
	        processData: false, //prevent jQuery from automatically transforming the data into a query string
	        contentType: false,
//	        dataType : "json",
//	        contentType: "application/json; charset=utf-8",
	        cache: false,
	        timeout: 600000,
	        success: function (data) {
//	            $("#result").text(data);
	        	handleData(data);
//	            console.log("SUCCESS : ", data);
//	            $("#btnSubmit").prop("disabled", false);
	        },
	        error: function (e) {
//	            $("#result").text(e.responseText);
	            console.log("ERROR : ", e);
//	            $("#btnSubmit").prop("disabled", false);
	
	        }
	    });

	},GetAjaxJson : function(lcmethod, lcdata, lcadd, handleData) {
		lcFuntion = "GetAjaxJson";
		console.log("Function run : " + lcFuntion);
	    $.ajax({
	        type: lcmethod,
//	        enctype: 'multipart/form-data',
	        url: lcUrl + lcadd, //"http://localhost:8080/set-upload",
	        data: lcdata,
	        processData: false, //prevent jQuery from automatically transforming the data into a query string
//	        contentType: false,
//	        dataType : "json",
	        contentType: "application/json; charset=utf-8",
	        cache: false,
	        timeout: 600000,
	        success: function (data) {
	        	handleData(data);
	        },
	        error: function (e) {
	            console.log("ERROR : ", e);
	
	        }
	    });

	},GetPrint : function(){
		var mydata;
		Pace.restart();
		$("#ModalCrud").empty();
		lcContent = "<div class='ModalPrint'><div class='mprint'>" 
		+"<page size='A4'>Use the one</page>"
		//+"<page size='A4'>b</page>"
		//+"<page size='A4'>c</page>"
		+"</div></div>";
		mycon= '<div class="sidebar-footer hidden-small " style=" height: 3.5em; border-radius: 10px 0px 0px 10px ; right:22.5%; bottom: 0.5%">'
			+'<a data-toggle="tooltip" data-placement="top" title="" data-original-title="Print" onclick="appmain.GoPrint()">'
			+'<span class="glyphicon glyphicon-print" aria-hidden="true"></span>'
			+'</a> <a data-toggle="tooltip" data-placement="top" title="" data-original-title="FullScreen">'
			+'<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>'
			+'</a> <a data-toggle="tooltip" data-placement="top" title="" data-original-title="Lock">' 
			+'<span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>'
			+'</a> <a data-toggle="tooltip" data-placement="top" title="" data-original-title="Close" onclick="appmain.ClosePrint()">' 
			+'<span class="glyphicon glyphicon-off" aria-hidden="true"></span>'
			+'</a>'
			+'</div>'
		$("#ModalCrud").append(lcContent);
		$("#ModalCrud").append(mycon);
		//$("#ModalCrud").show();
//		appmain.GetAjaxJson("POST", mydata, "get-podata", function(output) {
//			appmain.ProcessData(output,pagetype);
//		});
		appmain.GoPrint()
	},GoPrint : function(){
		$(".mprint").printThis({ 
		    debug: false,              
		    importCSS: true,             
		    importStyle: true,         
		    printContainer: true,       
		    loadCSS: "../css/print.css", 
		    pageTitle: "My Modal",             
		    removeInline: false,        
//		    printDelay: 100,            
		    header: null,             
		    formValues: true          
		}); 
		//$(".mprint").printElement();
//		window.print();
		 //$(".mprint").jqprint();
//		var doc = new jsPDF();
//
//		var specialElementHandlers = {
//			'#editor': function(element, renderer){
//				return true;
//			}
//		};
//		doc.fromHTML($('.mprint').get(0), 15, 15, {
//			'width': 170, 
//			'elementHandlers': specialElementHandlers
//		});
//		 doc.save('sample-file.pdf');
	},ClosePrint :function(){
		
		$("#ModalCrud").empty();
		$("#ModalCrud").hide();
	}
	
	
}

function getHide(){
	 $('#message').fadeOut(350, function(){ 
		  $('#message').hide(); 
	  });
//	  $('#loader').hide();
	
}

function getShow(){
	 $('#message').fadeIn(350, function(){ 
		  $('#message').show();
	  });
//	  $('#loader').hide();
}

function getClose(obj){
	 $(obj).fadeOut(350, function(){
	      $(obj).remove(); // after fadeout remove from DOM
	    });
	  getHide();
}
