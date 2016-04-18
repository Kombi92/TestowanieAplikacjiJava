Given a messenger

When connect to wp.com
Then connection should return 1

When connect to wp.pl
Then connection should return 0

When given server wp.pl and message okey
Then sending should return 0 or 1

When given server wp.com and message okey
Then sending should return 1

When given server wp.pl and message a
Then sending should return 2