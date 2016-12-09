# MovieRecommenderAssignment

This program reads data from a file and parses it. It serialises the lists and puts them into a compressed xml files.
If the xml file already exists it will try to read it first.

The user is able to add  a new user, remove user, view all users, add a movie, add a rating (to a movie that already exists and if
it doesn't the user will be asked if he wants to add one before adding the rating), see all movies sorted by rating/date/popularity,
search for a movie (non case sensitive), get all user ratings, get user recommendations (either by gender preference or by similiarity
to other users), show top 10 movies (based on popularity mainly but must have a good rating).
