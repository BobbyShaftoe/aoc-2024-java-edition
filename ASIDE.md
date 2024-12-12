# Aside
One of the really nice things that languages like Rust, oCaml, R, Scala, Elixir etc. have is their functional programming features and syntax.
And while I really **_don't_** want to write ~~Rust~~, and _**might**_ have a go at playing with _oCaml_,
I want to actually focus on languages that are closer in scope to my day job, and as such, explore the limits of functional programming in those.

Also, I just like functional programming, and at the very least, this is just another good learning experience, but there's a bit more to it... read on.

## Functional Programming Concepts
_This is not an exhaustive list, but are the key concepts people will generally call out when talking about functional programming_

* Pure Functions: Pure functions are deterministic functions with no side effects. They always produce the same output for a given set of inputs and don’t modify external state.
* First-Class Functions: First-class functions treat functions as variables, allowing them to be passed as arguments to other functions and returned as values. This enables functions to be assigned to variables and stored in data structures.
* Higher-Order Functions: Higher-order functions take functions as arguments or return functions. This allows for the creation of more abstract and reusable code, enabling powerful code composition.
* Immutability: Immutability involves not modifying data outside of functions. Instead, pure functions create new instances of data, which ensures that functions only return new values and don’t have side effects on existing data.
* Recursion: Recursion is the act of a function calling itself until it meets an exit condition. This technique is widely used in functional programming to solve problems that can be broken down into smaller, repetitive tasks.
* Function Composition: Function composition combines pure functions to create more complex functions. By chaining functions together, you can create a pipeline of operations that transform data step by step.
* Referential Transparency: Referential transparency ensures that a function’s return value can be freely replaced with its result without affecting the rest of the program. This property enables code optimization and reasoning about code behavior.
* Currying: Currying is the process of converting a function that takes multiple arguments into a series of functions that each take a single argument. This technique allows for partial application of functions and simplifies function composition.

## Here's The Thing

> The following considers Terraform as the primary language, but the concepts are applicable to any declarative language.

What it all comes down to, has been the trend in people desiring declarative languages to do functional things, and in a declarative language you can only do so much; especially in a true DSL.  
This is something that has been quite evident in Terraform over the years.
Most likely, the lack of Pure and First-Class Functions, and to a lesser extent Higher-Order Functions and possibly Recursion,
that limit the ability to handle more complex scenarios, are what has driven this.

Therefore, a common situation we find ourselves in is looking for creative ways to approximate the functionality we're looking for when dealing with a particular use-case.   
One of the most prevalent examples we've seen, is the embedding pseudo-functional stuff into local variables (`locals{}`), and then using those variables in the resource definitions.

Terraform does have some **_functional-like_** programming concepts, such as functional composition and referential transparency, and there is a need for things at least **_somewhat_** like these to exist, as they are incredibly useful in infrastructure as code.  
These concepts are seen in functions within expressions; comprehensions; iterating over variables, or any combination of these.

Terraform does also exhibit other functional programming concepts like immutability, pure functions and possibly recursion, but these tend to exist only as varying degrees of abstraction or as pseudo-functionality built in to the core language.   
These concepts are evident in the way Terraform manages state and handles resource management, data sources, and the ability to define modules.

**To more completely illustrate this point, some examples to perhaps consider are:**
1. **Dynamic Resource Creation**: Using higher-order functions and first-class functions, Terraform could dynamically create resources based on complex conditions and inputs, making infrastructure more adaptable and reusable.
2. **Advanced Data Transformations**: By extending function composition and pure functions, Terraform could handle more complex data transformations, such as better filtering, mapping, and reducing data sets, which is currently limited by the existing expression language.
3. **Recursive Resource Definitions**: Recursion could enable more complex resource definitions, such as nested resources or hierarchical resource structures, which are difficult to achieve with the current iteration constructs.
4. **Custom Logic and Abstractions**: First-class functions and higher-order functions would allow users to define custom logic and abstractions, making it easier to encapsulate and reuse complex infrastructure patterns.
5. **Enhanced Error Handling**: Functional programming concepts like monads could improve error handling and recovery, making it easier to manage and propagate errors in a controlled manner.

> NOTE: The above examples are purely hypothetical and may not be feasible or practical in the context of Terraform. They are intended to illustrate the potential benefits of functional programming concepts in the _infrastructure as code_ domain.

## The Plan
I want to deeply explore functional programming in a few languages; and by proxy or indirectly one might say, comprehensively understand the limits of what can be achieved with a declarative language for infrastructure as code; **Terraform** and **OPA (Rego)** in particular.  
If I get lucky, I might even come up with a new idea or some novel approach to solving a problem that I can share. 
