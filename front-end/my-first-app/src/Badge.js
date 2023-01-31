import { useState } from "react";

function Badge(props){

    const [count, setCount] = useState(0);

    const handleClick = () => {
        console.log('click event..');
        setCount(count+1);
        //logic
    }

    return (
        <button onClick={handleClick} type="button" className="btn btn-primary">
            {props.caption} <span className="badge text-bg-secondary">{count}</span>
        </button>
    )
}

export default Badge;