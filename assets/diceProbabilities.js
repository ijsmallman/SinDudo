function fact(num)
{
	if (num <= 1)
	{
		return 1;
	}
	else
	{
		return num * fact(num - 1);
	}
}

function prob(n,q)
{
	return Math.pow(1.0/6.0,q)*Math.pow(5.0/6.0,n-q)*fact(n)/(fact(q)*fact(n-q));
}

function probAtLeastKfromN(N,K)
{
	var p = 0.0;
	for (var i=K; i<(N+1); i++)
	{
		p += prob(N,i);	
	}
	return p;
}