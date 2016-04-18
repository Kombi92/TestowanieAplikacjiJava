Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: scenario description


Given a list
When add to list Nazwa: Sloneczny Wysokosc: 15.5 Ilosc: 15
Then should return 1

When add to list Nazwa: Ladny Wysokosc: 10.5 Ilosc: 10
Then should return 2

When remove from Nazwa: Ladny Wysokosc: 10.5 Ilosc: 10
Then after delete should return 1