# petrescuebackend

# Pet Rescue Template

This is a the backend that works with the frontend website created using React.  It is deployed using Heroku and can be found at [Generic Pet rescue](https://updated-pet-rescue-app.herokuapp.com) 
This is the backend, so the part that handles the database and models for the animals and people related to the backend.  It was developed in Java using PostgreSql.
The front end is at [Generic Pet rescue](https://updated-pet-rescue-app.herokuapp.com) 

## Installation

This is a web application, so there is no installation process.  You simply need to use the urls provided to access the specified endpoints.
to enter the site.  This site currently works with the deployed frontend.  The backend is the part that handles the database interactions, via the API.

## Usage

The intended user for this is rescue organizations.  While there are a large amount of website templates available, they don't necessarily meet the needs of the rescue where you want to show the public all of the available animals and gain their interest, but also want to keep all of the information regarding the animals and the people involved in the organization.

This current version is extremely generic, as the purpose is to be flexible so that small rescue organizations can easily modify it to their own needs.

On the associated frontend, there is a login page so that only authorized users (owner, volunteer) can access certain aspects.  The goal of the page is to be flexible and easily modified 
so that small groups can easily create a website that fits their needs.  There are some unique needs that rescues have that aren't met with generic websites.  

## Endpoints
http://localhost:8080

### CATS table in database
@RequestMapping("http://localhost:8080/api/v1/cats/")
// all @GetMapping for cats: allcats, byid, byvetting, (*)byage, byadoptionstatus, (*)needsfoster
// (*)(*)(*)need to add time in THEN bytime 
	GET:
ALL CATS: http://localhost:8080/api/v1/cats/api/v1/cats/allcats
CAT with an id: http://localhost:8080/api/v1/cats/individualcat/{id}     {id} is the integer id for the cat
CAT by vetting: http://localhost:8080/api/v1/cats/byvetting/{vetting}       {vetting} is Y/N
CAT by adoption status: http://localhost:8080/api/v1/cats/byadoptionstatus/{adoptionstatus}"    {adoption status} is NONE/APPLIED/APPROVED/DENIED/COMPLETED
//needs foster if foster is NONE
//by age - adult or kitten YEARS or !YEARS

    POST:
create a new cat: http://localhost:8080/api/v1/cats/addcat			[] {needs a cat object}

    PUT:
update a cat: http://localhost:8080/api/v1/cats/cat/{id}			[] {needs to be in the format of a cat object}, can add only updates

    DELETE:
remove a cat: ("/api/v1/cats/removecat/{id}")


### DOGS table in database
@RequestMapping("http://localhost:8080/api/v1/dogs/")
// all @GetMapping for dogs: alldogs, byid, byvetting, (*)byage, byadoptionstatus, (*)needsfoster
// (*)(*)(*)need to add time in THEN bytime 
	GET:
ALL DOGS: http://localhost:8080/api/v1/dogs/api/v1/dogs/alldogs
DOG with an id: http://localhost:8080/api/v1/dogs/individualdog/{id}     {id} is the integer id for the dog
DOG by vetting: http://localhost:8080/api/v1/dogs/byvetting/{vetting}       {vetting} is Y/N
DOG by adoption status: http://localhost:8080/api/v1/dogs/byadoptionstatus/{adoptionstatus}"    {adoption status} is NONE/APPLIED/APPROVED/DENIED/COMPLETED
//needs foster if foster is NONE
//by age - adult or puppy YEARS or !YEARS

    POST:
create a new dog: http://localhost:8080/api/v1/dogs/adddog			[] {needs a dog object}

    PUT:
update a dog: http://localhost:8080/api/v1/dogs/dog/{id}			[] {needs to be in the format of a dog object}, can add only updates

    DELETE:
remove a dog: ("/api/v1/dogs/removedog/{id}")



### PEOPLE table in database

	@GetMapping("/adoptersbystatus/{adopterstatus}")
	@PostMapping("addperson")
	@PutMapping("person/{id}")
	@DeleteMapping("/removeperson/{id}")

PEOPLE table in database
@RequestMapping("http://localhost:8080/api/v1/people/")
	GET:
ALL PEOPLE: http://localhost:8080/api/v1/people/api/v1/people/allpeople
PEOPLE with an id: http://localhost:8080/api/v1/people/individualperson/{id}     {id} is the integer id for the person
PEOPLE who are active volunteers: http://localhost:8080/api/v1/people/allvolunteers
PEOPLE who are active fosters: http://localhost:8080/api/v1/people/allfosters
adopter by status: http://localhost:8080/api/v1/people/allfosters/adoptersbystatus/{adopterstatus}  {adopterstatus}

    POST:
create a new person: http://localhost:8080/api/v1/people/addperson			[] {needs a person object}

    PUT:
update a person: http://localhost:8080/api/v1/people/person/{id}			[] {needs to be in the format of a person object}, can add only updates

    DELETE:
remove a person: ("/api/v1/people/removeperson/{id}")

## Future updates
More filtering of animals and people
Have volunteer inputs


