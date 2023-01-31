import React, { Component } from 'react'

export default class BadgeWithClass extends Component {

    constructor(){
        super();
        this.state = {count: 0};
        console.log('constructor')
    }

    componentDidMount() { 
        console.log('component did mount .. initialize..')
        //http call
     }

     componentDidUpdate() { 
        console.log('component did update ..')
     }

     shouldComponentUpdate(){
        console.log('should comp update...', this.state.count)
        return false;
     }
   
    handleClick(){
        console.log('click event..');
        // setCount(count+1);
        this.setState({count: this.state.count+1})
        //logic
    }


  render() {
    console.log('component render method..')
    return (
        <button onClick={this.handleClick.bind(this)} type="button" className="btn btn-primary">
            {this.props.caption} <span className="badge text-bg-secondary">{this.state.count}</span>
        </button>
    )
  }
}
