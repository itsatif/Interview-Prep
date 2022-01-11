//Q1 What is Pure Component & React.Component

// Components in react gave us the power top split the UI into independent, reusable pieces and which are isolated.

//Pure Component is similar to component but it does not implement shouldComponentUpdate() method,
//It impleents it with shallow prop and state comparison
//If normal compoent's render function renders the same result with the given props and state,then PureComponent should be use for a performnance boosting
// pure component's shouldComponentUpdate() only shallowly compares the objects,


//shouldComponentUpadte() is a lifecycle method of react which customize the default behaviour and implement it when the react component re-render itself
