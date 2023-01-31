import React, { useState } from 'react'
import DropdownItem from './DropdownItem';

export default function Dropdown() {

    const [show, setshow] = useState(false)
    const [caption, setCaption] = useState();
    const [cuisines, setcuisines] = useState(['North Indian', 'Mexican', 'Japanese'])

    const toggleShow = () => {
        setshow(!show)
    }
    const changeCaption = (c) => {
        console.log(c);
        setCaption(c)
        setshow(false)
    }


    let cuisineList = cuisines.map((cuisine, i)=>{
        return <DropdownItem key={i} cuisine={cuisine} onItemChange={changeCaption}></DropdownItem>
    })

    return (
        <div className="dropdown">
            <button onClick={toggleShow} className="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                {caption? caption :'Select cuisine'}
            </button>
            <ul className={show?'dropdown-menu show': 'dropdown-menu'}>
            {cuisineList}
            </ul>
        </div>
    )
}
