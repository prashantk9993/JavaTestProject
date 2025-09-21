Facade Design Pattern
1. It provides a unified, simplified interface to set of complex subsystems.
2. Instead of client directly interacting with multiple services (which creates tight
coupling), they interact with the single facade class.
3. This increases abstraction, security and maintainability.

Facade Pattern in Banking Application - Fund transfer use case
    Imagine a fund transfer operation in bank.
    Without Facade, a client has to call multiple services manually.
1. Authentication service - validate customer
2. Account Service - check balance, debit account
3. Transaction Service - create transaction entry
4. Notification Service - send SMS / Email Confirmation
5. Audit Service - log for compliance 

That's lots of steps to manage for a client.
