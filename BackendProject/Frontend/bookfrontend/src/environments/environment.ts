// an environment is an object containing key-value pairs
// we can use these wherever we import them in our app
// they get baked in at compile-time
// ng g environments to create environments object

export const environment = {
    production: true,
    backendURL: 'http://localhost:8080/'
};
