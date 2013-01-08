function ClientToken(token) {
	var args = token.split('@');
	if (args.length !== 2) {
		throw 'invalid token';
	}
	this.userId = parseInt(args[0]);
	this.userToken = args[1];

	if (isNaN(this.userId)) {
		throw 'invalid token';
	}
}