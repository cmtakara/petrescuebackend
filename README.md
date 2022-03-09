# petrescuebackend

# Pet Rescue Template

This is a website created using React.  It is deployed using Heroku and can be found at [Generic Pet rescue](https://pet-rescue-app.herokuapp.com/)

## Installation

This is a web application, so there is no installation process.  You simply need to use the url provided to enter the site.

## Usage

This current version is extremely generic, as the purpose is to be flexible so that small rescue organizations can easily modify it to their own needs.
There is a login page so that only authorized users (owner, volunteer) can access certain aspects.  The goal of the page is to be flexible and easily modified 
so that small groups can easily create a website that fits their needs.  There are some unique needs that rescues have that aren't met with generic websites.

## Endpoints
http://localhost:8080
CATS table in database
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


DOGS table in database
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




@RequestMapping("api/v1/people/")
	@GetMapping("/allpeople")
	@GetMapping("/individualperson/{id}")
	@GetMapping("/allvolunteers")
	@GetMapping("/allfosters")
	@GetMapping("/adoptersbystatus/{adopterstatus}")
	@PostMapping("addperson")
	@PutMapping("person/{id}")
	@DeleteMapping("/removeperson/{id}")

PEOPLE table in database
@RequestMapping("http://localhost:8080/api/v1/people/")
	GET:
ALL PEOPLE: http://localhost:8080/api/v1/dogs/api/v1/people/allpeople
PEOPLE with an id: http://localhost:8080/api/v1/people/individualperson/{id}     {id} is the integer id for the person
PEOPLE who are active volunteers: http://localhost:8080/api/v1/people/allvolunteers
PEOPLE who are active fosters: http://localhost:8080/api/v1/people/allfosters


DENIED/COMPLETED
//needs foster if foster is NONE
//by age - adult or puppy YEARS or !YEARS

    POST:
create a new dog: http://localhost:8080/api/v1/dogs/adddog			[] {needs a dog object}

    PUT:
update a dog: http://localhost:8080/api/v1/dogs/dog/{id}			[] {needs to be in the format of a dog object}, can add only updates

    DELETE:
remove a dog: ("/api/v1/dogs/removedog/{id}")

## Future updates
Display unique list of cats
Have a generic dogs display
Display unique list of dogs
Have volunteer inputs

### dependencies
