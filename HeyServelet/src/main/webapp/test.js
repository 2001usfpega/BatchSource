//scrape dealer.com site
//javascript: (function() {
	var prom = prompt("Send me URLs").split(/ |\t/);
	var progress = [ prom.length, 0 ];
	var workStack = [];
	$("body").html('');
	document.title = progress[1] + '/' + progress[0];
	for (var i = 0; i < prom.length; i++) {
		jeff(prom[i]);
	}

	function jeff(n) {
		workStack.push($.ajax({
			method : 'GET',
			url : n,
			cache : false,
			success : function(result) {
				var out = '';
				out += '<div>' + n + '</div>';
				out += '<h1>' + $(result).find(".ddc-page-title").text().trim()
						+ '</h1>';
				out += '<div>' + $(result).find(".content").text() + '</div>';
				out += '<div>' + "******************" + '</div>';
				progress[1]++;
				document.title = progress[1] + '/' + progress[0];
				document.body.innerHTML += out;
				console.log($(result).html());
			},
			error : function() {
				alert(n + ' is fucked!');
			}
		}));
	}
})();

// look
javascript: (function() {
	var loc = window.location.hostname;
	var tit = document.title;
	var info = [ '', 'vin', 'GET', '0', '0' ];
	if (loc == "old site") {
		info[0] = 'http://www.vernonautogroup.com/catcher.esl?vin=';
		info[2] = "HEAD"
	} else if (loc == "www.vernonautogroup.com") {
		info[0] = 'https://www.vernonautogroup.com/inventory/';
		info[1] = /#\w\d{4,5}\w? \| Vernon Auto Group/;
	} else if (loc == "www.texomahyundai.com") {
		info[0] = 'www.texomahyundai.com/catcher.esl?vin=';
		info[1] = "For Sale | Sherman TX";
	} else if (loc == "www.toyotaofsantafe.com") {
		info[0] = 'https://www.toyotaofsantafe.com/inventory/';
		info[1] = / \| Toyota of Santa Fe/;
	} else if (loc == "www.greenvillechrysler.com") {
		info[0] = 'https://www.greenvillechrysler.com/vehicle-details/new-';
	} else if (loc == "www.bigspringford.com") {
		info[0] = 'https://www.bigspringford.com/catcher.esl?vin=';
		info[1] = "For Sale | Big Spring TX";
	} else {
		alert("Where am I?");
		exit;
	}
	var out2 = "";
	var prom = prompt("Send me some VINs.").split(/ |\t/);
	var d = [];
	for (var i = 0; i < prom.length; i++) {
		if (prom[i].length < 5) {
			prom[i] = 'miss';
		} else {
			jeff(i);
		}
	}
	$.when.apply(null, d).always(function() {
		for (var j = 0; j < prom.length; j += 10) {
			var out = "";
			var count = 0;
			for (var i = Math.min(9, prom.length - j - 1); i >= 0; i--) {
				if ((prom[i + j] == 'miss' && count > 0) || !prom[i + j]) {
					out = ' ' + (i + 1) + out;
				}
				if (prom[i + j] != 'miss' && count == 0) {
					count = Math.min(8, i + 1);
				}
			}
			if (out == "") {
				out = "Everything looks good";
				if (count < 8) {
					out += " but there are only " + (count) + " units";
				}
			} else {
				out = "These are gone:" + out;
				if (count < 8) {
					out += " and there are only " + (count) + " units";
				}
			}
			out2 += out + '\n';
		}
		document.title = tit;
		alert(out2);
	});
	function jeff(n) {
		info[3]++;
		document.title = info[4] + '/' + info[3];
		d.push($.ajax({
			method : info[2],
			url : info[0] + prom[n],
			cache : false,
			success : function(result) {
				if (info[1] == "vin") {
					prom[n] = $(result).filter('title').text()
							.includes(prom[n]);
				} else {
					prom[n] = $(result).filter('title').text().match(info[1]);
				}
				info[4]++;
				document.title = info[4] + '/' + info[3];
			},
			error : function() {
				prom[n] = false;
				alert(n + ' is fucked!');
			}
		}));
	}
//})();