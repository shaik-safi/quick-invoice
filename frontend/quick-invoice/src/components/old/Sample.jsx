import React, {useState} from "react";
import { Image, Col, Row } from "react-bootstrap";
function Test() {
    const [file, setFile] = useState();
    function handleChange(e) {
        console.log(e.target.files);
        console.log(URL.createObjectURL(e.target.files[0]));
        setFile(URL.createObjectURL(e.target.files[0]));
    }
 
    return (
        <div className="App">
            <h2>Add Image:</h2>
            <input type="file" onChange={handleChange} />
            {/* <img src={file} /> */}
            <Row>
                <Col className="col-6">
                <Image src={file} fluid />
                </Col>
            </Row>
            
        </div>
 
    );
}

export default Test