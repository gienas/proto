<html>

<head>

</head>
<body>
	<h2>Hello World!</h2>

	<script>
		//local test mode
		//if (document.location.hostname.indexOf("localhost") != -1) {

		//production	
		if (document.location.hostname.indexOf("oferty.praca.gov.pl") != -1) {
			(function(i, s, o, g, r, a, m) {
				i['GoogleAnalyticsObject'] = r;
				i[r] = i[r] || function() {
					(i[r].q = i[r].q || []).push(arguments)
				}, i[r].l = 1 * new Date();
				a = s.createElement(o), m = s.getElementsByTagName(o)[0];
				a.async = 1;
				a.src = g;
				m.parentNode.insertBefore(a, m)
			})(window, document, 'script',
					'//www.google-analytics.com/analytics.js', 'ga');

			//local test mode
			//ga('create', 'UA-51770916-1', 'none');
			//production use 
			ga('create', 'UA-51770916-1', 'oferty.praca.gov.pl');

			ga('send', 'pageview')
		}
	</script>

</body>
</html>
